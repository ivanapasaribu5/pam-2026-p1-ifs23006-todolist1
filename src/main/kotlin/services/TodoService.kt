package services

import entities.Todo
import repositories.ITodoRepository

class TodoService(private val todoRepository: ITodoRepository) : ITodoService {

    override fun showTodos() {
        val todos = todoRepository.getAllTodos()

        println("Daftar Todo:")
        if (todos.isEmpty()) {
            println("- Data todo belum tersedia!")
        } else {
            todos.forEach { println(it) }
        }
    }

    override fun addTodo(title: String) {
        val newTodo = Todo(title = title)
        todoRepository.addTodo(newTodo)
    }

    override fun removeTodo(id: Int) {
        if (!todoRepository.removeTodo(id)) {
            println("[!] Gagal menghapus todo dengan ID: $id")
        }
    }

    override fun updateTodo(id: Int, newTitle: String) {
        if (!todoRepository.updateTodo(id, newTitle)) {
            println("[!] Todo dengan ID $id tidak ditemukan")
        }
    }

    override fun searchTodo(keyword: String) {
        val result = todoRepository.searchTodo(keyword)
        println("Hasil Pencarian:")
        if (result.isEmpty()) {
            println("- Todo tidak ditemukan")
        } else {
            result.forEach { println(it) }
        }
    }

    override fun sortTodo() {
        val sorted = todoRepository.sortTodoByTitle()
        println("Todo Setelah Diurutkan:")
        sorted.forEach { println(it) }
    }
}
