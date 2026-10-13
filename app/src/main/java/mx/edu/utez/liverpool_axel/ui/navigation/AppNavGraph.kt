package mx.edu.utez.liverpool_axel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import mx.edu.utez.liverpool_axel.ui.screens.TituloScreen
import mx.edu.utez.liverpool_axel.ui.screens.detalles.DetallesScreen
import mx.edu.utez.liverpool_axel.ui.screens.productos.ProductosScreen
import mx.edu.utez.liverpool_axel.ui.screens.productos.ProductosViewModel


sealed class Route(val path: String){
    object Titulo : Route("titulo")
    object Productos : Route("productos")
    object Detalles : Route("detalles")
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val viewModelCompartido: ProductosViewModel = viewModel()
    NavHost(
        navController =navController,
        startDestination = Route.Titulo.path,
        modifier =modifier
    ){
        composable(route = Route.Titulo.path){
            TituloScreen(
                onNavigateToProductos = {navController.navigate(Route.Productos.path)}
            )

        }

        composable(route = Route.Productos.path){
            ProductosScreen(
                viewModel = viewModelCompartido,
                onNavigateToDetalles = {navController.navigate(Route.Detalles.path)},
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(route = Route.Detalles.path){
            DetallesScreen(
                viewModel = viewModelCompartido,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}