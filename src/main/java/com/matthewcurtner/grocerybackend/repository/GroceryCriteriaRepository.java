package com.matthewcurtner.grocerybackend.repository;

import com.matthewcurtner.grocerybackend.model.Grocery;
import com.matthewcurtner.grocerybackend.model.GroceryPage;
import com.matthewcurtner.grocerybackend.model.GrocerySearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class GroceryCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public GroceryCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Grocery> findAllWithFilters(GroceryPage groceryPage,
                                            GrocerySearchCriteria grocerySearchCriteria) {
        CriteriaQuery<Grocery> criteriaQuery = criteriaBuilder.createQuery(Grocery.class);
        Root<Grocery> groceryRoot = criteriaQuery.from(Grocery.class);
        Predicate predicate = getPredicate(grocerySearchCriteria, groceryRoot);
        criteriaQuery.where(predicate);
        setOrder(groceryPage, criteriaQuery, groceryRoot);

        TypedQuery<Grocery> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(groceryPage.getPageNumber() * groceryPage.getPageSize());
        typedQuery.setMaxResults(groceryPage.getPageSize());

        Pageable pageable = getPageable(groceryPage);
        long groceryCount = getGroceryCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, groceryCount);
    }

    private Predicate getPredicate(GrocerySearchCriteria grocerySearchCriteria,
                                   Root<Grocery> groceryRoot) {
        List<Predicate> predicateList = new ArrayList<>();
        if (Objects.nonNull(grocerySearchCriteria.getName())) {
            predicateList.add(criteriaBuilder.like(groceryRoot.get("name"),
                    "%" + grocerySearchCriteria.getName() + "%"));
        }

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }

    private void setOrder(GroceryPage groceryPage,
                          CriteriaQuery<Grocery> criteriaQuery,
                          Root<Grocery> groceryRoot) {
        if (groceryPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(groceryRoot.get(groceryPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(groceryRoot.get(groceryPage.getSortBy())));
        }
    }

    private Pageable getPageable(GroceryPage groceryPage) {
        Sort sort = Sort.by(groceryPage.getSortDirection(), groceryPage.getSortBy());
        return PageRequest.of(groceryPage.getPageNumber(), groceryPage.getPageSize(), sort);
    }

    private long getGroceryCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Grocery> countRoot = countQuery.from(Grocery.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);

        return entityManager.createQuery(countQuery).getSingleResult();
    }

}
