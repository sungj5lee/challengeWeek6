package com.example.challengeweek6

object TodoManager {
    private val todoList: MutableList<TodoData> = mutableListOf()

    init {
        todoList.add(TodoData("장보기", "야채, 우유, 계란 사기", true))
        todoList.add(TodoData("애완동물 고르기", "전산동 84 동물보호 센터에서 고르기", false))
        todoList.add(TodoData("지퍼 고치기", "다이소에서 지퍼 찾아야한다.", false))
        todoList.add(TodoData("이번 주 숙제", "", true))
    }
    fun addTodoData(data: TodoData) {
        todoList.add(data)
    }

    fun removeTodoData(position : Int) {
        todoList.removeAt(position)
    }

    fun getList(): MutableList<TodoData> {
        return todoList
    }

    fun toggleTodo(position: Int){
        todoList[position].bookmarked= todoList[position].bookmarked.not()
    }

    fun editTodo(position: Int, title: String, body: String){
        todoList[position].title=title
        todoList[position].body=body
    }
}