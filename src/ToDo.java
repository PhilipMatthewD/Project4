import java.util.Iterator;

public class ToDo implements Comparable<ToDo>, Iterable<ToDo>{
    private String title;
    private String desc;
    private String priority;

    public ToDo(String title, String desc, String priority) {
        this.title = title;
        this.desc = desc;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ToDo" + "; title = " + title + ", desc = " + desc + ", priority = " + priority;
    }

    @Override
    public int compareTo(ToDo o) {
        if(this.priority.equals(o.priority)){
            return this.title.compareTo(o.title);
        }else{
            return this.priority.compareTo(o.priority);
        }
    }

    @Override
    public Iterator<ToDo> iterator() {
        return null;
    }
}
