package core.persistence.projections;

import java.util.Date;

public interface IUrpWeakUser {
   String getUserName();
   Date getIssuedDate();
   int  getWeak();
}
