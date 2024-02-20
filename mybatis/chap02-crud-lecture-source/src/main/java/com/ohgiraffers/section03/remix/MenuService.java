package com.ohgiraffers.section03.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.Template.getSqlSession;

/* 설명.
 *  Service 계층 이후부터는 xml방식, javaconfig방식, remix방식 중 어떤 것을 선택할 지 고민해서 진행해야 한다.
 *  remix 방식의 경우는
 *  mybatis 설정은 javaconfig 방식을 취하고, 쿼리를 다루는 것은 xml 방식을 취한다.
 *  DAO에 해당하는 것은 추상메소드를 지닌 인터페이스로 만드는데 이 인터페이스와 mapper용 xml은 세가지를 준수해야한다.
 *  1. xml파일은 mapper용 인터페이스(DAO에 해당하는 인터페이스)와 같은 경로에 위치해야 한다.
 *  2. xml파일의 namespace는 mapper용 인터페이스로 작성해야 한다. (풀네임으로)
 *  3. xml파일명과 mapper용 인터페이스명이 동일해야 한다.
* */
public class MenuService {
    public List<MenuDTO> findAllMenu() {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.selectAllMenus();

        sqlSession.close();
        return menus;
    }

    public MenuDTO findMenu(int menuCode) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = menuMapper.selectMenu(menuCode);

        sqlSession.close();
        return menu;
    }

    public boolean addMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return (result>0)? true:false;

    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(menu);
        System.out.println(result);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return (result>0)? true:false;

    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menuCode);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return (result>0)? true:false;

    }
}
