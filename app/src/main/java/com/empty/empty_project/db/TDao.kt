package  com.empty.empty_project.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.empty.empty_project.db.tentities.TEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TDao {

    @Query("SELECT * FROM ttable")
    fun getAll(): Flow<List<TEntity>>

    @Upsert
    fun insertItem(item: TEntity)
}