```mermaid
graph TD
    A[GlobalHeader]
    B[GlobalFooter]
    C[GlobalMenu]

    A --> D[DashboardPage]
    B --> D
    C --> D

    A --> E[ClothesPage]
    B --> E
    C --> E

    A --> F[ArtPage]
    B --> F
    C --> F

    A --> G[AccessoriesPage]
    B --> G
    C --> G

    A --> H[MenPage]
    B --> H
    C --> H

    A --> I[WomenPage]
    B --> I
    C --> I

    A --> J[StationaryPage]
    B --> J
    C --> J

    A --> K[HomeAccessoriesPage]
    B --> K
    C --> K

    D --> E[ClothesPage]
    D --> F[ArtPage]
    D --> G[AccessoriesPage]

    E --> H[MenPage]
    E --> I[WomenPage]

    G --> J[StationaryPage]
    G --> K[HomeAccessoriesPage]
