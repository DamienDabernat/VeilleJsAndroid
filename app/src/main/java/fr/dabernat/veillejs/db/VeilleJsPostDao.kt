package fr.dabernat.veillejs.db

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import fr.dabernat.veillejs.vo.VeilleJsPost

interface VeilleJsPostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<VeilleJsPost>)
}