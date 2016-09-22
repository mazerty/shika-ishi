package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;

public class MyGrid<T> extends Grid {

    public MyGrid(Class<T> beanType) {
        super(new BeanItemContainer<>(beanType));
    }

}
