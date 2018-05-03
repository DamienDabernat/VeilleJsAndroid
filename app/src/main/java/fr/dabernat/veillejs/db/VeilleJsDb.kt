package fr.dabernat.veillejs.db

import android.arch.persistence.room.*
import android.content.Context
import com.google.gson.annotations.SerializedName
import fr.dabernat.veillejs.vo.VeilleJsPost
import java.security.AccessControlContext

/**
 * You can set annotation processor argument (room.schemaLocation) to tell Room to export
 * the schema into a folder. Even though it is not mandatory, it is a good practice
 * to have version history in your codebase and you should commit that file into
 * your version control system (but don't ship it with your app!).
 *
 * Kotlin has “class” for classes that have multiple instances, and “object” for singletons.
 * I believe Scala makes the same distinction?
 * “companion object” is an extension of the concept of “object”: an object that is a companion
 * to a particular class, and thus has access to it’s private level methods and properties.
 * Using the companion object adds consistency to the language design, whereas “static”
 * is not consistent with the rest of the language design.
 */
@Database(
        entities = [VeilleJsPost::class],
        version = 1,
        exportSchema = true
)
abstract class VeilleJsDb : RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory : Boolean): VeilleJsDb {
            val databaseBuilder = if(useInMemory) {
                Room.inMemoryDatabaseBuilder(context, VeilleJsDb::class.java)
            } else {
                Room.databaseBuilder(context, VeilleJsDb::class.java, "VeilleJs.db")
            }
            return databaseBuilder
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }

    abstract fun posts(): VeilleJsPostDao
}
