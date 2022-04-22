package hrms.hrmssystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAnnouncement"})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<JobAnnouncement> jobAnnouncements;
}
