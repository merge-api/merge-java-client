package com.merge.api.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.merge.api.accounting.types.AccountCompany;
import com.merge.api.accounting.types.CompanyInfo;
import com.merge.api.core.ObjectMappers;
import org.junit.jupiter.api.Test;

public final class OneOfUnionTest {

    @Test
    public void deserializesStringVariant() throws Exception {
        AccountCompany company =
                ObjectMappers.JSON_MAPPER.readValue("\"c47cf0d5-722d-45bd-b807-6e38489d37fe\"", AccountCompany.class);
        assertTrue(company.get() instanceof String);
        assertEquals("c47cf0d5-722d-45bd-b807-6e38489d37fe", company.get());
    }

    @Test
    public void deserializesObjectVariant() throws Exception {
        String json = "{\"id\":\"c-1\",\"name\":\"Acme\"}";
        AccountCompany company = ObjectMappers.JSON_MAPPER.readValue(json, AccountCompany.class);
        assertTrue(company.get() instanceof CompanyInfo);
        assertEquals("Acme", ((CompanyInfo) company.get()).getName().orElse(null));
    }

    @Test
    public void stringVariantRoundTrips() throws Exception {
        AccountCompany company = AccountCompany.of("c-1");
        String serialized = ObjectMappers.JSON_MAPPER.writeValueAsString(company);
        assertEquals("\"c-1\"", serialized);
    }

    @Test
    public void objectVariantRoundTrips() throws Exception {
        AccountCompany company =
                AccountCompany.of(CompanyInfo.builder().name("Acme").build());
        String serialized = ObjectMappers.JSON_MAPPER.writeValueAsString(company);
        AccountCompany reparsed = ObjectMappers.JSON_MAPPER.readValue(serialized, AccountCompany.class);
        assertTrue(reparsed.get() instanceof CompanyInfo);
        assertEquals("Acme", ((CompanyInfo) reparsed.get()).getName().orElse(null));
    }
}
