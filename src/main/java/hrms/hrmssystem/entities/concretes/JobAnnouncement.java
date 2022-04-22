package hrms.hrmssystem.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="job_announcements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","city","position","employer","jobApplications"})
public class JobAnnouncement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String jobDescription;

    @Column(name="numberof_open_positions")
    private int numberOfOpenPositions;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="min_salary")
    private double minSalary;

    @Column(name="max_salary")
    private double maxSalary;

    @Column(name="is_active")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "jobAnnouncement",fetch = FetchType.EAGER)
    private List<JobApplication> jobApplications;

}
