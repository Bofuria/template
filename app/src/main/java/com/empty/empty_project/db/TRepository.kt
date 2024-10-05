package  com.empty.empty_project.db

import com.empty.empty_project.db.TDao
import com.empty.empty_project.db.tentities.TEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TRepository @Inject constructor(
    private val tDao: TDao
) {
    fun getAll(): Flow<List<TEntity>> {
        return tDao.getAll()
    }

    fun insertItem(item: TEntity) {
        return tDao.insertItem(item)
    }
}