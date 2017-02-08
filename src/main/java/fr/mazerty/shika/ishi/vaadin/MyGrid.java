package fr.mazerty.shika.ishi.vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;

import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Custom {@link Grid} with integrated {@link BeanItemContainer}
 */
public class MyGrid<T> extends Grid {

    private BeanItemContainer<T> beanItemContainer;

    @SuppressWarnings("unchecked")
    public MyGrid(Class<T> beanType) {
        super(new BeanItemContainer<>(beanType));

        // stored here once and for all
        beanItemContainer = (BeanItemContainer<T>) getContainerDataSource();
    }

    /**
     * Sets the header captions of visible columns in order of appearance
     */
    public void setColumnHeaderCaptions(String... captions) {
        IntStream.range(0, captions.length)
                .forEach(i -> getColumns().get(i).setHeaderCaption(captions[i]));
    }

    /**
     * @see BeanItemContainer#addAll(Collection)
     */
    public void addAll(Collection<? extends T> collection) {
        beanItemContainer.addAll(collection);
    }

}
