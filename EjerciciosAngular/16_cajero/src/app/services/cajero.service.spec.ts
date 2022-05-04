/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CajeroService } from './cajero.service';

describe('Service: Cajero', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CajeroService]
    });
  });

  it('should ...', inject([CajeroService], (service: CajeroService) => {
    expect(service).toBeTruthy();
  }));
});
