package com.projectmanagement.basics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class demonstrates ALL JUnit 5 annotations and assertions.
 * This is purely for LEARNING — not linked to our app yet.
 *
 * NAMING CONVENTION for test classes:
 *   → ClassNameTest.java (e.g., ProjectServiceImplTest)
 *
 * NAMING CONVENTION for test methods:
 *   → methodName_StateUnderTest_ExpectedBehavior
 *   → Example: createProject_WhenNameIsDuplicate_ShouldThrowException
 */
class JUnit5BasicsTest {

    // =====================================================
    // @BeforeAll — Runs ONCE before ALL tests in this class
    // Must be static
    // Use for: expensive setup like DB connection, file load
    // =====================================================
    @BeforeAll
    static void initAll() {
        System.out.println("====== TEST CLASS STARTED ======");
        System.out.println("@BeforeAll: Runs ONCE before everything");
    }

    // =====================================================
    // @AfterAll — Runs ONCE after ALL tests finish
    // Must be static
    // Use for: cleanup resources like closing DB connections
    // =====================================================
    @AfterAll
    static void tearDownAll() {
        System.out.println("====== TEST CLASS FINISHED ======");
        System.out.println("@AfterAll: Runs ONCE after everything");
    }

    // =====================================================
    // @BeforeEach — Runs before EVERY single test method
    // Use for: creating fresh objects before each test
    // =====================================================
    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach: Preparing fresh data for next test...");
    }

    // =====================================================
    // @AfterEach — Runs after EVERY single test method
    // Use for: resetting state, clearing lists, etc.
    // =====================================================
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach: Cleaning up after test...\n");
    }

    // =====================================================
    // BASIC @Test — Simple test method
    // =====================================================
    @Test
    void simpleAddition_ShouldReturnCorrectSum() {
        // ARRANGE — Prepare the data
        int a = 5;
        int b = 3;

        // ACT — Perform the action
        int result = a + b;

        // ASSERT — Verify the result
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    // =====================================================
    // assertEquals — Checks if two values are equal
    // =====================================================
    @Test
    void assertEquals_Example() {
        String expected = "Project Alpha";
        String actual = "Project Alpha";

        assertEquals(expected, actual);
        // If not equal → test FAILS with clear message
    }

    // =====================================================
    // assertNotNull — Checks if object is NOT null
    // =====================================================
    @Test
    void assertNotNull_Example() {
        String projectName = "Healthcare App";

        assertNotNull(projectName, "Project name should not be null");
    }

    // =====================================================
    // assertNull — Checks if object IS null
    // =====================================================
    @Test
    void assertNull_Example() {
        String projectName = null;

        assertNull(projectName, "Project name should be null here");
    }

    // =====================================================
    // assertTrue / assertFalse
    // =====================================================
    @Test
    void assertTrue_And_assertFalse_Example() {
        int cost = 5000;
        int revenue = 10000;

        assertTrue(revenue > cost, "Revenue should be greater than cost");
        assertFalse(cost > revenue, "Cost should NOT be greater than revenue");
    }

    // =====================================================
    // assertThrows — Verify an exception IS thrown
    // THIS IS VERY IMPORTANT for testing error cases
    // =====================================================
    @Test
    void assertThrows_Example() {
        // We expect this code to throw ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0; // This throws ArithmeticException
        });
    }

    // =====================================================
    // assertThrows — Capture and check the exception message
    // =====================================================
    @Test
    void assertThrows_WithMessageCheck_Example() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validateProjectName("") // This method throws the exception
        );

        assertEquals("Project name cannot be empty", exception.getMessage());
    }

    // =====================================================
    // assertAll — Run multiple assertions together
    // Even if one fails, ALL are checked and reported
    // =====================================================
    @Test
    void assertAll_Example() {
        String projectName = "Smart City";
        double cost = 50000.0;
        double revenue = 100000.0;

        assertAll("Project fields validation",
                () -> assertNotNull(projectName),
                () -> assertEquals("Smart City", projectName),
                () -> assertTrue(cost > 0),
                () -> assertTrue(revenue > cost)
        );
    }

    // =====================================================
    // @DisplayName — Gives a human-readable test name
    // Shows in test reports and IDE output
    // =====================================================
    @Test
    @DisplayName("When revenue is more than cost, profit should be positive")
    void profitCalculation_ShouldBePositive() {
        double cost = 30000.0;
        double revenue = 70000.0;
        double profit = revenue - cost;

        assertTrue(profit > 0);
    }

    // =====================================================
    // @Disabled — Temporarily SKIP a test
    // Use when: test is broken, feature not ready
    // =====================================================
    @Test
    @Disabled("Feature not yet implemented — skipping for now")
    void futureFeatureTest_ShouldPass() {
        // This test will be SKIPPED
        assertEquals(1, 2); // Would fail, but won't run
    }

    // ─── Helper method used in test above ───────────────
    private void validateProjectName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty");
        }
    }
}