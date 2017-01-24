package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.data.fieldgroup.BeanFieldGroup;

/**
 * Custom {@link BeanFieldGroup} with quicker access to the bean
 */
public class MyBeanFieldGroup<T> extends BeanFieldGroup<T> {

    public MyBeanFieldGroup(Class<T> beanType) {
        super(beanType);
        setBuffered(false);
    }

    public T getBean() {
        return getItemDataSource().getBean();
    }

    public void setBean(T bean) {
        setItemDataSource(bean);
    }

}
