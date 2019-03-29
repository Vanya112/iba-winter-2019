import { StatusCodePipe } from './status-code.pipe';

describe('StatusCodePipe', () => {
  it('create an instance', () => {
    const pipe = new StatusCodePipe();
    expect(pipe).toBeTruthy();
  });
});
