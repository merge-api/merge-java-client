package com.merge.api.integration;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.core.SyncPagingIterable;
import java.util.Optional;
import java.util.function.Function;

final class IntegrationSupport {

    private static final int MAX_ITEMS = 5;

    private IntegrationSupport() {}

    static <T> void smokeList(SyncPagingIterable<T> page) {
        assertNotNull(page);
        int count = 0;
        for (T item : page) {
            assertNotNull(item);
            if (++count >= MAX_ITEMS) {
                break;
            }
        }
    }

    static void smokeListAndRetrieve(SyncPagingIterable<?> page, Function<String, Object> retriever) {
        assertNotNull(page);
        Object firstItem = null;
        int count = 0;
        for (Object item : page) {
            assertNotNull(item);
            if (firstItem == null) {
                firstItem = item;
            }
            if (++count >= MAX_ITEMS) {
                break;
            }
        }

        String id = idOf(firstItem);
        if (id == null) {
            return;
        }

        Object retrieved = retriever.apply(id);
        assertNotNull(retrieved);
        assertEquals(id, idOf(retrieved));
    }

    @SuppressWarnings("unchecked")
    static String idOf(Object item) {
        if (item == null) {
            return null;
        }
        try {
            Object value = item.getClass().getMethod("getId").invoke(item);
            if (value instanceof Optional) {
                return ((Optional<String>) value).orElse(null);
            }
            return value == null ? null : value.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
