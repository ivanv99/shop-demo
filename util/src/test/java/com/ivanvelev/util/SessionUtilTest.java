package com.ivanvelev.util;

import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SessionUtilTest {
    @Test
    public void testSessionFactory() {
        try (Session session = SessionUtil.getSession()) {
            assertNotNull(session);
        }
    }
}
