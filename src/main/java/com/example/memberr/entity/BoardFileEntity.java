package com.example.memberr.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.FatalBeanException;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_file_table")
public class BoardFileEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

//    자식 엔티티에는 이런 형식으로 정의
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") //실제 DB에 만들어지는 컬럼 이름
    private BoardEntity boardEntity; //부모 엔티티

    public static BoardFileEntity toBoardFileEntity(BoardEntity boardEntity, String originalFileName, String storedFileName) {
        BoardFileEntity boardFileEntity = new BoardFileEntity();
        boardFileEntity.setOriginalFileName(originalFileName);
        boardFileEntity.setStoredFileName(storedFileName);
        boardFileEntity.setBoardEntity(boardEntity);
        return boardFileEntity;
    }
}
