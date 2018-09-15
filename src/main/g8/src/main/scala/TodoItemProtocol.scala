/*
 * Copyright 2017-2018 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright 2017-2018 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package examples.todolist
package protocol

import freestyle.rpc.protocol._

trait TodoItemProtocol {

  final case class TodoItemMessage(item: String, todoListId: Int, completed: Boolean, id: Int)

  final case class TodoItemRequest(item: String, todoListId: Int)

  final case class TodoItemList(list: List[TodoItemMessage])

  final case class TodoItemResponse(msg: Option[TodoItemMessage])

  @service(Avro)
  trait TodoItemRpcService[F[_]] {

    def reset(empty: Empty.type): F[MessageId]

    def insert(item: TodoItemRequest): F[TodoItemResponse]

    def retrieve(id: MessageId): F[TodoItemResponse]

    def list(empty: Empty.type): F[TodoItemList]

    def update(item: TodoItemMessage): F[TodoItemResponse]

    def destroy(id: MessageId): F[MessageId]

  }

}
