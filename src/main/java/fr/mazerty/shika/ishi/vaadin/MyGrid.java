package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;

/**
 * Custom {@link Grid} with integrated {@link BeanItemContainer}
 */
public class MyGrid<T> extends Grid {

    public MyGrid(Class<T> beanType) {
        super(new BeanItemContainer<>(beanType));
    }

}
