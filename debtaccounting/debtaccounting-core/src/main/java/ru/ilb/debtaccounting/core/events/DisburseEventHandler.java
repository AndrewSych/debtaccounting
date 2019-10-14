/*
 * Copyright 2019 Bystrobank.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.ilb.debtaccounting.core.events;

import ru.ilb.debtaccounting.entities.AlreadyDisbursedException;
import ru.ilb.debtaccounting.entities.DebtStatusCode;
import ru.ilb.debtaccounting.entities.DisburseEvent;
import ru.ilb.debtaccounting.entities.EventHandler;
import ru.ilb.debtaccounting.entities.Loan;

/**
 *
 * @author slavb
 */
public class DisburseEventHandler extends EventHandler<DisburseEvent, Loan> {

    public DisburseEventHandler(Loan debt) {
        super(debt);
    }

    @Override
    public void process(DisburseEvent event) {
        if (debt.getStatus() != DebtStatusCode.CREATED) {
            throw new AlreadyDisbursedException();
        }

        debt.setStatus(DebtStatusCode.DISBURSED);
    }

}
