package hrms.hrmssystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAnnouncement"})
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "position",fetch = FetchType.EAGER)
    private List<JobAnnouncement> jobAnnouncements;

}
