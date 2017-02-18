package com.yona.estore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yona.estore.dao.CartDao;
import com.yona.estore.model.Cart;

//@Repository =serves as Accessing Data by spring 
@Repository
@Transactional
public class CartDaoImpl implements CartDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Cart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        // to do later
    }
}

//    private Map<String, Cart> listOfCarts;
//
//    public CartDaoImpl() {
//        listOfCarts = new HashMap<String, Cart>();
//    }
//
//    public Cart create(Cart cart) {
//        if (listOfCarts.keySet().contains(cart.getCartId())) {
//            throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the given id(%) " +
//                    "already " + "exists", cart.getCartId()));
//        }
//
//        listOfCarts.put(cart.getCartId(), cart);
//
//        return cart;
//    }
//    
//
//    public Cart read(String cartId) {
//        return listOfCarts.get(cartId);
//    }
//
//    public void update(String cartId, Cart cart) {
//        if (!listOfCarts.keySet().contains(cartId)) {
//            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id(%) " +
//                    "does not " + "exist", cart.getCartId()));
//        }
//
//        listOfCarts.put(cartId, cart);
//    }
//
//    public void delete (String cartId) {
//        if (!listOfCarts.keySet().contains(cartId)) {
//            throw new IllegalArgumentException(String.format("Can not delete cart. A cart with the given id(%) " +
//                    "does not " +
//                    "exist", cartId));
//        }
//
//        listOfCarts.remove(cartId);
//    }
    
    
