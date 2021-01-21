package sandbox;

public class Toto {

    boolean flag;
    double score;
    MyCat cls;

    public Toto(boolean flag, double score, MyCat cls) {
        this.flag = flag;
        this.score = score;
        this.cls = cls;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MyCat getCls() {
        return cls;
    }

    public void setCls(MyCat cls) {
        this.cls = cls;
    }
}
