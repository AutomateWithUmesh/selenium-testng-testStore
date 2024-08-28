```mermaid
classDiagram
    LoginPage --> DashboardPage
    DashboardPage --> HeaderPage
    DashboardPage --> MenuPage
    DashboardPage --> FooterPage
    HeaderPage --> SigninPage
    HeaderPage --> ViewAccountPage
    HeaderPage --> CartPage
    MenuPage --> ClothesPage
    MenuPage --> AccessoriesPage
    MenuPage --> ArtPage
    ClothesPage --> MenPage
    ClothesPage --> WomenPage
    AccessoriesPage --> StationaryPage
    AccessoriesPage --> HomeAccessoriesPage

    class LoginPage {
        +enterUsername()
        +enterPassword()
        +clickSignInButton()
    }

    class DashboardPage {
        +getHeader()
        +getMenu()
        +getFooter()
    }

    class HeaderPage {
        +clickSigninButton()
        +clickViewAccount()
        +clickCart()
    }

    class SigninPage {
        +enterUsername()
        +enterPassword()
        +submitLogin()
    }

    class ViewAccountPage {
        +viewAccountDetails()
        +editAccountDetails()
    }

    class CartPage {
        +viewCartItems()
        +checkout()
    }

    class MenuPage {
        +goToClothes()
        +goToAccessories()
        +goToArt()
    }

    class ClothesPage {
        +goToMen()
        +goToWomen()
    }

    class AccessoriesPage {
        +goToStationary()
        +goToHomeAccessories()
    }

    class ArtPage {
        +viewArtCollection()
    }

    class MenPage {
        +viewMenTshirts()
        +viewMenShoes()
    }

    class WomenPage {
        +viewWomenDresses()
        +viewWomenShoes()
    }

    class StationaryPage {
        +viewPens()
        +viewNotebooks()
    }

    class HomeAccessoriesPage {
        +viewCushions()
        +viewLamps()
    }

