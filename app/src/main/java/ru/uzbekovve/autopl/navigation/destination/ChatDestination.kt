package ru.uzbekovve.autopl.navigation.destination

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import ru.uzbekovve.autopl.ui.screens.chat.ChatId
import ru.uzbekovve.autopl.ui.screens.chat.ChatScreen

private const val CHAT_SCREEN = "chat"
private const val CHAT_SCREEN_ID = "id"
private const val DEEPLINK_SCHEME = "shout"

fun NavGraphBuilder.chat() {
    composable(route = "$CHAT_SCREEN/{$CHAT_SCREEN_ID}",
        arguments = listOf(
            navArgument(CHAT_SCREEN_ID) {
                type = NavType.StringType
                nullable = false
            }
        ),
        deepLinks = listOf(navDeepLink {
            uriPattern = "$DEEPLINK_SCHEME://$CHAT_SCREEN/{$CHAT_SCREEN_ID}"
        })
    ) { navBackStackEntry ->
        val arguments = requireNotNull(navBackStackEntry.arguments)
        val encodedChatId = arguments.getString(CHAT_SCREEN_ID).orEmpty()
        val chatId = Uri.decode(encodedChatId)
        ChatScreen(chatId)
    }
}

fun NavController.navigateToChat(
    chatId: ChatId
) {
    val encodedChatId = Uri.encode(chatId)
    navigate("$CHAT_SCREEN/{$encodedChatId}")
}