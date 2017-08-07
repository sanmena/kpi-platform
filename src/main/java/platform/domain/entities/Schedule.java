package platform.domain.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String schedule;

    private String condition;

    private Integer score;

    @Column(name = "self_evaluation")
    private Integer selfEvaluation;

    @Column(name = "re_evaluation")
    private Integer reEvaluation;

    @Column(name = "final_evaluation")
    private Integer finalEvaluation;


    private Integer type;

    @Temporal(TemporalType.DATE)
    @Column(name = "evaluation_date")
    private Date evaluationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(Integer selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }

    public Integer getReEvaluation() {
        return reEvaluation;
    }

    public void setReEvaluation(Integer reEvaluation) {
        this.reEvaluation = reEvaluation;
    }

    public Integer getFinalEvaluation() {
        return finalEvaluation;
    }

    public void setFinalEvaluation(Integer finalEvaluation) {
        this.finalEvaluation = finalEvaluation;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
