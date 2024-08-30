# Selenium Automation Framework

## Overview

This Selenium automation framework is designed for testing a web application using the Page Object Model (POM) pattern. The framework utilizes Selenium WebDriver with TestNG for test execution, and incorporates Cucumber for behavior-driven development (BDD). It supports parallel test execution and integrates with Extent Reports for reporting.

## Framework Structure

### Pages

The framework follows the Page Object Model pattern, organizing page elements and actions into distinct classes. Here are the key page classes in the framework:

- **GlobalHeader**: Represents the header section visible on all pages.
- **GlobalFooter**: Represents the footer section visible on all pages.
- **GlobalMenu**: Represents the global menu for navigation.

### Pages Hierarchy

The following Mermaid diagram illustrates the page hierarchy and relationships in the framework:

```mermaid
graph TD
    A[LoginPage] --> B[HomePage]
    
    B --> C[GlobalHeader]
    B --> D[GlobalFooter]
    B --> E[GlobalMenu]

    E --> G[ClothesPage]
    E --> H[ArtPage]
    E --> I[AccessoriesPage]

    C --> N[SignOutPage]
    C --> O[MyAccountPage]
    C --> P[CartPage]

    D --> Q[ReferencePage]

    G --> J[MenPage]
    G --> K[WomenPage]

    I --> L[StationaryPage]
    I --> M[HomeAccessoriesPage]
```

### Test Case Flow

The following Mermaid diagram illustrates the test case flow:


```mermaid
flowchart TD
    A[Start Test Case] --> B[Load Configuration Properties]
    B --> C[Initialize WebDriver]
    C --> D[Load Test Data]
    D --> E[Login to Application]
    E --> F[Perform Test Actions]
    F --> G[Verify Test Results]
    G --> H[Log Test Results]
    H --> I[Sign Out from Application]
    I --> J[Close WebDriver]
    J --> K[End Test Case]

    subgraph Initialization
        B[Load Configuration Properties] --> L[Load Properties from config]
        L --> M[Set Up Grid or Local WebDriver]
        M --> C
    end

    subgraph Data Setup
        D[Load Test Data] --> N[Get Test Data Path from Parameters]
        N --> O[Use ResourceLoader to Read JSON]
        O --> P[Convert JSON to Java Objects]
        P --> E
    end

    subgraph Test Execution
        E[Login to Application] --> Q[Call Login Method]
        Q --> R[Perform Actions Based on Test Data]
        R --> S[Interact with Page Elements]
    end

    subgraph Validation
        G[Verify Test Results] --> T[Assert Expected Outcomes]
        T --> U[Handle Assertion Failures]
    end

    subgraph Cleanup
        H[Log Test Results] --> V[Update Test Report]
        V --> W[Log Details in Extent Report]
        W --> X[Sign Out from Application]
        X --> Y[Handle Logout Success/Failure]
        Y --> J
    end
```