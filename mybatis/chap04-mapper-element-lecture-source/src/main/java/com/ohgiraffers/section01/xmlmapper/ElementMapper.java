package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

public interface ElementMapper {
    public List<MenuDTO> selectResultMapTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
