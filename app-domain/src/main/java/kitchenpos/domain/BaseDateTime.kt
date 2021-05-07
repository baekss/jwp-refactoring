package kitchenpos.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseDateTime {
    @CreatedDate
    @Column(updatable = false)
    private var createdDate: LocalDateTime? = null

    open fun getCreateDate(): LocalDateTime {
        return this.createdDate!!
    }

    @LastModifiedDate
    private var modifiedDate: LocalDateTime? = null

    open fun getModifiedDate(): LocalDateTime {
        return this.modifiedDate!!
    }
}
