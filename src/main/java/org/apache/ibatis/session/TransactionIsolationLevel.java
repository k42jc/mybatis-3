/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * 对应数据库事务隔离级别
 * 从上至下级别逐渐提高，随着事务隔离级别增强，效率降低，数据安全(这里只脏读、幻读)提高
 *
 * 无 不设置，使用数据库默认事务隔离级别
 * 读未提交 存在脏读、幻读、不可重复读
 * 读提交 存在幻读、不可重复读
 * 可重复读 存在幻读 是mysql的默认事务隔离级别
 * 序列化 最强级别，采用锁表的方式实现，同一时间只能有一个事务提交
 *
 * @author Clinton Begin
 */
public enum TransactionIsolationLevel {
  NONE(Connection.TRANSACTION_NONE),
  READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
  READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
  REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
  SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

  private final int level;

  private TransactionIsolationLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
