package cn.edu.cqut.stats;

public class SimpleCategory {
    private String name;
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object[] toArray() {
        return new Object[] {name, count };
    }
}
