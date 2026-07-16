package com.merge.api.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.core.QueryStringMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.Test;

public final class ExpandQueryParamTest {

    private static HttpUrl.Builder base() {
        return HttpUrl.parse("https://api.merge.dev/api").newBuilder();
    }

    @Test
    public void expandListJoinsAsSingleCommaSeparatedParam() {
        HttpUrl.Builder builder = base();
        QueryStringMapper.addQueryParameter(builder, "expand", Arrays.asList("account", "assignees", "creator"), false);
        HttpUrl url = builder.build();

        assertEquals(1, url.queryParameterValues("expand").size());
        assertEquals("account,assignees,creator", url.queryParameter("expand"));
    }

    @Test
    public void expandStringAndListProduceIdenticalUrl() {
        HttpUrl.Builder fromList = base();
        QueryStringMapper.addQueryParameter(fromList, "expand", Arrays.asList("account", "assignees"), false);

        HttpUrl.Builder fromString = base();
        QueryStringMapper.addQueryParameter(fromString, "expand", "[account, assignees]", false);

        assertEquals(fromList.build().query(), fromString.build().query());
    }

    @Test
    public void emptyExpandListIsOmitted() {
        HttpUrl.Builder builder = base();
        QueryStringMapper.addQueryParameter(builder, "expand", new ArrayList<String>(), false);
        assertNull(builder.build().query());
    }

    @Test
    public void nonExpandListWithArraysAsRepeatsProducesRepeatedParams() {
        HttpUrl.Builder builder = base();
        QueryStringMapper.addQueryParameter(builder, "ids", Arrays.asList("a", "b"), true);
        HttpUrl url = builder.build();
        assertEquals(Arrays.asList("a", "b"), url.queryParameterValues("ids"));
    }

    @Test
    public void nestedObjectFlattensToBracketKeys() {
        HttpUrl.Builder builder = base();
        Map<String, Object> inner = new HashMap<>();
        inner.put("baz", "qux");
        Map<String, Object> outer = new HashMap<>();
        outer.put("foo", inner);

        QueryStringMapper.addQueryParameter(builder, "filter", outer, false);
        HttpUrl url = builder.build();
        assertEquals("qux", url.queryParameter("filter[foo][baz]"));
    }
}
