package com.example.sentiment.repository.interfaces;


import com.example.sentiment.crud.interfaces.CRUDInterface;
import com.example.sentiment.crud.interfaces.CRUDRepositoryInterface;
import com.example.sentiment.dto.board.BoardDTO;
import com.example.sentiment.repository.model.Board;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface BoardRepository extends CRUDRepositoryInterface<Board> {
    @Override
    int create(Board board);

    @Override
    Board findById(int id);

    @Override
    int deleteById(int id);

    @Override
    int update(Board Board);

    @Override
    List<Board> findAll();
}
