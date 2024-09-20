package woowacourse.shopping.application

import android.content.Context
import com.example.di.Module
import com.example.di.annotation.Qualifier
import com.example.di.annotation.QualifierType
import woowacourse.shopping.data.repository.DatabaseCartRepository
import woowacourse.shopping.data.repository.DefaultProductRepository
import woowacourse.shopping.data.repository.InMemoryCartRepository
import woowacourse.shopping.domain.repository.CartRepository
import woowacourse.shopping.domain.repository.ProductRepository
import woowacourse.shopping.local.dao.CartProductDao
import woowacourse.shopping.local.db.ShoppingDatabase

class AppModule(private val context: Context) : Module {
    fun provideCartProductDao(): CartProductDao {
        return ShoppingDatabase.getInstance(context).cartProductDao()
    }

    fun provideDefaultProductRepository(): ProductRepository {
        return DefaultProductRepository()
    }

    @Qualifier(QualifierType.InMemory)
    fun provideInMemoryCartRepository(): CartRepository {
        return InMemoryCartRepository()
    }

    @Qualifier(QualifierType.Database)
    fun provideDatabaseCartRepository(cartProductDao: CartProductDao): CartRepository {
        return DatabaseCartRepository(cartProductDao)
    }
}
