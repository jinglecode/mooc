package edu.whut.cs.jee.mooc.mclass.dto;

import edu.whut.cs.jee.mooc.mclass.model.ExaminationRecord;
import edu.whut.cs.jee.mooc.upms.model.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ExaminationRecordDto implements Serializable {

    private Long examinationId;

    private Long userId;

    private String userName;

    private Double score;

    private Integer correctCount;

    private Date submitTime;

    private List<AnswerDto> answerDtos;

    public ExaminationRecord convertTo(){
        ExaminationRecord examinationRecord = new ExaminationRecord();
        BeanUtils.copyProperties(this, examinationRecord);
        User user = new User();
        user.setId(this.userId);
        examinationRecord.setUser(user);
        return examinationRecord;
    }

    public ExaminationRecordDto convertFor(ExaminationRecord examinationRecord){
        BeanUtils.copyProperties(examinationRecord,this);
        this.setUserName(examinationRecord.getUser().getName());
        return this;
    }

}
