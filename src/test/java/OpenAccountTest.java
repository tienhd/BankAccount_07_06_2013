import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/7/13
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenAccountTest {
    BankAccountDao mockBankAccountDao = mock(BankAccountDao.class);

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        BankAccount.setBankAccountDao(mockBankAccountDao);
    }

    @Test
    public void testIfCanGetDTOfromDao() {
        String accountNumber = "1234567890";
        BankAccountDTO bankAccountDTO = BankAccount.findByAccountNumber(accountNumber);
        verify(mockBankAccountDao).findByAccountNumber(accountNumber);
    }

    @Test
    public void testOpenNewAccountWithZeroBalance() {
        String accountNumber = "1234567890";
        BankAccount.openAccount(accountNumber);

        ArgumentCaptor<BankAccountDTO> openAccountRecords = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDao,times(1)).saveRecordToDB(openAccountRecords.capture());

        assertEquals(0,0.01, openAccountRecords.getValue().getBalance());
        assertEquals(accountNumber, openAccountRecords.getValue().getAccountNumber());

    }
}
