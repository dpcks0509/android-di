package woowacourse.shopping.ui.cart

import android.content.Context
import com.example.di.annotation.Qualifier
import com.example.di.annotation.QualifierType
import woowacourse.shopping.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateFormatter(
    @Qualifier(QualifierType.ActivityContext) context: Context,
) {
    private val formatter =
        SimpleDateFormat(
            context.getString(R.string.date_format),
            Locale.KOREA,
        )

    fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}
