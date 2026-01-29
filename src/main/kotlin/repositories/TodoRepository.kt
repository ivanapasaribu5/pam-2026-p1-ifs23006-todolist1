package repositories

import entities.Todo

class TodoRepository : ITodoRepository {
    private val data = ArrayList<Todo>()

    override fun getAllTodos(): ArrayList<Todo> {
        return data
    }

    override fun addTodo(newTodo: Todo) {
        data.add(newTodo)
    }

    override fun removeTodo(id: Int): Boolean {
        val target = data.find { it.id == id } ?: return false
        data.remove(target)
        return true
    }

    override fun updateTodo(id: Int, newTitle: String): Boolean {
        val todo = data.find { it.id == id } ?: return false
        todo.title = newTitle
        return true
    }

    override fun searchTodo(keyword: String): List<Todo> {
        return data.filter {
            it.title.contains(keyword, ignoreCase = true)
        }
    }

    override fun sortTodoByTitle(): List<Todo> {
        return data.sortedBy { it.title }
    }
}
