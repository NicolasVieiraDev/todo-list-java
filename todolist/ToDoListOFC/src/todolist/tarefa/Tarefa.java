package todolist.tarefa;

public class Tarefa {

    private Integer id;
    private String task;
    private Boolean stats;

    public Tarefa(Integer id, String task, Boolean stats){
        this.id = id;
        this.task = task;
        this.stats = stats;
    }

    public Tarefa(Integer id, String task){
        this.id = id;
        this.task = task;
        this.stats = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStats() {
        return stats;
    }

    public void setStats(Boolean stats) {
        this.stats = stats;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String toString() {
        return "[" + id + "]" + task + " - " + (stats ? "Completed" : "Pending");
    }
}
