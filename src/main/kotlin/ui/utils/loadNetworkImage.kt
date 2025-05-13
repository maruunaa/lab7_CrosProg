package ui.utils

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.jetbrains.skia.Image
import java.net.URL

fun loadNetworkImage(url: String): ImageBitmap {
    val bytes = URL(url).openStream().readBytes()
    return Image.makeFromEncoded(bytes).asImageBitmap()
}
