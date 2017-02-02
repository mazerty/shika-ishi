package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;

import java.util.stream.IntStream;

/**
 * Custom {@link Grid} with integrated {@link BeanItemContainer}
 */
public class MyGrid<T> extends Grid {

    public MyGrid(Class<T> beanType) {
        super(new BeanItemContainer<>(beanType));
    }

    /**
     * Sets the header captions of visible columns in order of appearance
     */
    public void setColumnHeaderCaptions(String... captions) {
        IntStream.range(0, captions.length)
                .forEach(i -> getColumns().get(i).setHeaderCaption(captions[i]));
    }

}
