package com.taipark.service.impl;

        import com.taipark.dao.IAccountDao;
        import com.taipark.dao.impl.AccountDaoImpl;
        import com.taipark.service.IAccountService;

//账户的业务层实现类
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
