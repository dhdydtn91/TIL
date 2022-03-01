package gof.java.designpatterns.creational_patterns.prototype.before;

public class GithubIssue implements Cloneable {

    private int id;

    private String title;

    private GithubRepository repository;

    public GithubIssue (GithubRepository repository){
        this.repository = repository;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public GithubRepository getRepository() {
        return repository;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRepository(GithubRepository repository) {
        this.repository = repository;
    }

    public String getUrl() {
        return String.format("https://github.com/%s/%s/issues/%d",
                repository.getUser(),
                repository.getName(),
                this.getId());
    }


}
