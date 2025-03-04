# Online Coffee Shop

## Project Description
The **Online Coffee Shop** is an Android application that allows users to browse and purchase coffee beverages from a virtual coffee shop. Users can view different coffee categories, explore details of individual drinks, add items to their cart, and complete the checkout process.

## Features
- **User-friendly Interface**: Browse coffee categories like Espresso, Cappuccino, Tea, and Cold Drinks.
- **Shopping Cart Management**: Add, remove, or modify item quantities before checkout.
- **Detailed Product Descriptions**: View ingredients, pricing, and customer ratings for each drink.
- **Discount Codes**: Apply promotional discount codes at checkout.
- **Checkout Process**: Enter personal details and complete the order.
- **Animated Delivery Confirmation**: A motorcycle animation starts upon order completion.

## Application Architecture
The project follows the **MVVM (Model-View-ViewModel) architecture** with separate layers for UI, data management, and business logic.

### Activities
- **MainActivity**: Displays coffee categories, banners, and popular items.
- **ItemsListActivity**: Lists all available drinks within a selected category.
- **DetailActivity**: Provides detailed information about a selected drink.
- **CartActivity**: Shows items added to the shopping cart.
- **CheckoutActivity**: Handles user checkout and order confirmation.
- **SplashActivity**: Displays a splash screen before launching the app.

### Adapters
- **CartAdapter**: Manages the shopping cart list.
- **CategoryAdapter**: Displays available coffee categories.
- **ItemsListCategoryAdapter**: Manages item displays in the list.
- **PopularAdapter**: Displays popular coffee items.

### Domain Models
- **ItemsModel**: Represents coffee products.
- **CategoryModel**: Represents different coffee categories.
- **BannerModel**: Stores promotional banners.

### Data Management
- **TinyDB**: Handles local data storage.
- **ManagementCart**: Manages cart operations such as adding, updating, and removing items.
- **ChangeNumberItemsListener**: Updates item counts in the cart.

### Firebase Integration
- **MainRepository**: Fetches data from Firebase.
- **MainViewModel**: Manages LiveData for categories, banners, and popular items.

## Technologies Used
- **Android Studio**: Development environment.
- - **Java & Kotlin**: Core programming languages.
- **Firebase**: Backend services for database management and authentication.
- **RecyclerView & Adapters**: Dynamic UI components.

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/OnlineCoffeeShop.git
   ```
2. Open the project in **Android Studio**.
3. Configure **Firebase**:
   - Add `google-services.json` to the `app/` directory.
   - Set up Firestore Database and Firebase Authentication.
4. Build and run the app on an emulator or a physical Android device.

## Contributors
- **Maya & Team**

## License
This project is open-source and available under the **MIT License**.
