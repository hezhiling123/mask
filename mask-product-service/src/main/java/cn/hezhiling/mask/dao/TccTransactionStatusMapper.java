package cn.hezhiling.mask.dao;


import cn.hezhiling.mask.model.system.TccTransactionStatus;

public interface TccTransactionStatusMapper {
    TccTransactionStatus queryStatusById(TccTransactionStatus status);

    int insertStatus(TccTransactionStatus status);

    int updateStatus(TccTransactionStatus status);
}
