package ru.uzbekovve.autopl.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.uzbekovve.autopl.navigation.destination.GUIDE_SCREEN
import ru.uzbekovve.autopl.navigation.destination.allChats
import ru.uzbekovve.autopl.navigation.destination.auth
import ru.uzbekovve.autopl.navigation.destination.chat
import ru.uzbekovve.autopl.navigation.destination.main
import ru.uzbekovve.autopl.navigation.destination.navigateSignIn
import ru.uzbekovve.autopl.navigation.destination.navigateToAllChats
import ru.uzbekovve.autopl.navigation.destination.navigateToAuth
import ru.uzbekovve.autopl.navigation.destination.navigateToChat
import ru.uzbekovve.autopl.navigation.destination.signIn

@Composable
fun ShoutAppNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = GUIDE_SCREEN) {
        main(onLastFurtherClick = {
            navController.navigateSignIn()
        })
        signIn(onSignInCompleted = {
            navController.navigateToAuth()
        })
        auth(onAuthCompleted = {
            navController.navigateToAllChats()
        })
        allChats(onChatClick = { chatId ->
            navController.navigateToChat(chatId = chatId)
        })
        chat()
    }
}